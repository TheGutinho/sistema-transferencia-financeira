import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Transferencia {
  id?: number;
  contaOrigem: string;
  contaDestino: string;
  valor: number;
  taxa?: number;
  dataAgendamento?: string;
  dataTransferencia: string;
}

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {
  private apiUrl = 'http://localhost:8080/api/transferencias';

  constructor(private http: HttpClient) { }

  agendar(transferencia: Transferencia): Observable<any> {
    return this.http.post(this.apiUrl, transferencia);
  }

  listar(): Observable<Transferencia[]> {
    return this.http.get<Transferencia[]>(this.apiUrl);
  }
}